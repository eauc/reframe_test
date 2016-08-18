(ns reframe.styles
  (:require [reframe.styles.color :refer [color]]
            [reframe.styles.break :refer [break]]
            [reframe.styles.fonts :as fonts]
            [reframe.styles.layout :as layout]
            [reframe.components.nav.styles :as nav]
            [reframe.components.menu.styles :as menu]
            [garden.def :refer [defstyles]]))

(defstyles screen
  fonts/styles
  [:.reframe
   layout/styles
   nav/styles
   menu/styles])
