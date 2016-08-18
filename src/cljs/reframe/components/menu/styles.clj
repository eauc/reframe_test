(ns reframe.components.menu.styles
  (:require [reframe.styles.break :refer [break]]
            [garden.stylesheet :refer [at-media]]))

(def styles
  [:&-menu {:text-align "center"
            :min-height "3em"
            :border-top "1px solid #999"}
   [:&-toggle {:position "absolute"
               :bottom "3px"
               :right "3px"
               :font-size "1.5em"
               :line-height "1.5em"
               :padding "0em 0.6em"
               :background-color "white"
               :color "#333"
               :border "1px solid #999"
               :border-radius "0.4em"}
    [:&:hover {:background-color "#CCC"}]
    (at-media
     {:min-width (:tablet break)}
     [:& {:display "none"}]
    )]
   [:div {:display "none"
          :padding "0.5em"}
    [:&:hover {:background-color "#CCC"}]
    (at-media
     {:min-width (:tablet break)}
     [:& {:display "block" }]
     )]
   [:&.show
    [:div {:display "block"}]]
   (at-media
    {:min-width (:tablet break)}
    [:& {:min-height "auto"
         :display "flex"
         :flex-direction "row"
         :justify-content "space-around"}])
   (at-media
    {:min-width (:pc break)}
    [:& {:display "initial"
         :text-align "right"}])])
