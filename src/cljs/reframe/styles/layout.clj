(ns reframe.styles.layout
  (:require [reframe.styles.break :refer [break]]
            [garden.stylesheet :refer [at-media]]))

(def styles
  [:& {:display "flex"
       :flex-direction "column"
       :height "100vh"}
   [:&-content {:flex-grow 1
                :display "flex"
                :flex-direction "column"}]
   [:&-menu {:order 2}]
   [:&-page {:order 1
             :flex-grow 1
             :position "relative"}
    [:&-wrap {:position "absolute"
              :box-sizing "border-box"
              :width "100%"
              :height "100%"
              :overflow-y "auto"
              :padding "3px"}]]
   (at-media {:min-width (:pc break)}
    [:&-content {:flex-direction "row"}]
    [:&-menu {:order 0}]
    [:&-page {:order 0}]
    )])
