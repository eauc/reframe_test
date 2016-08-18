(ns reframe.components.nav.view
  (:require [re-frame.core :as re-frame]
            [reframe.db :as db]
            [reframe.components.nav.handler]
            [reframe.components.nav.sub]))

(defn nav-toggle []
  [:button.reframe-nav-toggle
   {:on-click #(re-frame/dispatch [:nav-toggle])}
   [:span.fa.fa-bars]
   ])

(defn nav-item [page]
  (let [pages (:pages db/default-db)
        page-label (get-in pages [page :label])
        page-url (str "#" (get-in pages [page :url]))
        active-page (re-frame/subscribe [:pages-active])]
    (fn []
      [:a.reframe-nav-item
       {:class (if (= page @active-page) "active")
        :href page-url}
       page-label])))

(defn view []
  (let [show-nav (re-frame/subscribe [:nav-show])]
    (fn []
      [:div.reframe-nav
       {:class (if @show-nav "show")}
       [:div.reframe-nav-brand "Reframe Test"
        [nav-toggle]]
       [nav-item :home]
       [nav-item :tasks]])))
