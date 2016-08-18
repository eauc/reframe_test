(ns reframe.components.nav.styles
  (:require [reframe.styles.color :refer [color]]
            [reframe.styles.break :refer [break]]
            [garden.units :as units]
            [garden.stylesheet :refer [at-media]]
            [reframe.styles.misc :as misc]))

(def nav-padding (units/em 0.2))

(def styles
  [:&-nav {:background-color (:primary color)
           :box-shadow misc/default-shadow}
   [:&-brand {:font-weight "bold"
              :font-size "1.5em"
              :color (:text-inverted color)
              :padding nav-padding}]
   [:&-toggle {:float "right"
               :background-color "transparent"
               :color (:text-inverted color)
               :padding [[nav-padding (units/em* 2 nav-padding)]]
               :border "none"
               :margin (units/em- (units/em 0) nav-padding)}
    [:&:focus {:outline "none"
               :background-color (:dark-primary color)}]
    [:&:hover {:background-color (:dark-primary color)}]]
   [:&-item {:display "none"
             :padding "0.5em"
             :text-decoration "none"
             :color (:text-inverted color)}
    [:&:hover :&.active {:background-color (:dark-primary color)}]]
   [:&.show
    [:.reframe-nav-item {:display "block"}]]
   (at-media {:min-width (:tablet break)}
             [:& {:display "flex"
                  :flex-direction "row"
                  :flex-wrap "reverse-wrap"}
              [:&-toggle {:display "none"}]
              [:&-item {:display "block"}]])])
