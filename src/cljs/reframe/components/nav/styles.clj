(ns reframe.components.nav.styles
  (:require [reframe.styles.color :refer [color]]
            [reframe.styles.break :refer [break]]
            [garden.units :as units]
            [garden.stylesheet :refer [at-media]]))

(def nav-padding (units/em 0.2))

(def styles
  [:&-nav {:background-color (:primary color)
           :color "white"
           :box-shadow "0px 1px 3px 0px #666"}
   [:&-brand {:font-weight "bold"
              :font-size "1.5em"
              :padding nav-padding}]
   [:&-toggle {:float "right"
               :background-color "transparent"
               :color "white"
               :padding [[nav-padding (units/em* 2 nav-padding)]]
               :border "none"
               :margin (units/em- (units/em 0) nav-padding)}
    [:&:focus {:outline "none"
               :background-color (:dark-primary color)}]
    [:&:hover {:background-color (:dark-primary color)}]]
   [:&-item {:display "none"
             :padding "0.5em"
             :text-decoration "none"
             :color "white"}
    [:&:hover :&.active {:background-color (:dark-primary color)}]]
   [:&.show
    [:.reframe-nav-item {:display "block"}]]
   (at-media {:min-width (:tablet break)}
    [:& {:display "flex"
         :flex-direction "row"
         :flex-wrap "reverse-wrap"}
     [:&-toggle {:display "none"}]
     [:&-item {:display "block"}]])])
