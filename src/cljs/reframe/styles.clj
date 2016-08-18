(ns reframe.styles
  (:require [garden.def :refer [defstyles]]
            [reframe.components.menu.styles :as menu]
            [reframe.components.nav.styles :as nav]
            [reframe.styles.break :refer [break]]
            [reframe.styles.color :refer [color]]
            [reframe.styles.fonts :as fonts]
            [reframe.styles.layout :as layout]
            [reframe.styles.misc :as misc]))

(defstyles screen
  fonts/styles
  misc/styles
  [:.reframe
   layout/styles
   nav/styles
   menu/styles])
