(ns reframe.components.app
  (:require [reframe.components.nav.view :as nav]
            [reframe.components.menu.view :as menu]
            [reframe.components.page.view :as page]))

(defn view []
  [:div.reframe
   [nav/view]
   [:div.reframe-content
    [menu/view]
    [page/view]]])
