(ns reframe.components.menu.view
  (:require [re-frame.core :as re-frame]
            [reframe.components.menu.sub]
            [reframe.components.menu.handler]
            [reframe.pages.home.view :as home]
            [reframe.pages.tasks.view :as tasks]))

(defn menu [page]
  (case page
    :home home/menu
    :tasks tasks/menu
    []))

(defn menu-toggle []
  [:button.reframe-menu-toggle
   {:on-click #(re-frame/dispatch [:menu-toggle])}
   [:span.fa.fa-ellipsis-v]
   ])

(defn show-menu [page show]
  (into [:div.reframe-menu
         {:class (if show "show")}
         [menu-toggle]
         ] (menu page)))

(defn view []
  (let [active-page (re-frame/subscribe [:pages-active])
        show (re-frame/subscribe [:menu-show])]
    (fn []
      [show-menu @active-page @show])))
