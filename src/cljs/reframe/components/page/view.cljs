(ns reframe.components.page.view
  (:require [re-frame.core :as re-frame]
            [reframe.components.page.sub]
            [reframe.components.page.handler]
            [reframe.pages.home.view :as home]
            [reframe.pages.tasks.view :as tasks]))

(defn page [active-page]
  (case active-page
    :home [home/page]
    :tasks [tasks/page]
    [:span]))

(defn show-page [active-page]
  [:div.reframe-page
   [:div.reframe-page-wrap
    (page active-page)]])

(defn view []
  (let [active-page (re-frame/subscribe [:pages-active])]
    (fn []
      [show-page @active-page])))
