(ns reframe.styles.misc
  (:require [reframe.styles.color :refer [color]]))

(def default-border "1px solid #666")
(def default-border-radius "3px")
(def default-shadow "0px 1px 3px 0px #999")

(def styles
  [[:body :button {:color (:text color) }]
  [:button {:background-color "white"
            :padding "0.5em"
            :border default-border
            :border-radius default-border-radius}
   [:&:hover {:background-color (:hover color)}]
   [:&:focus {:outline "none"}]]])
