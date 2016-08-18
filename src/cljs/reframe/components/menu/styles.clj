(ns reframe.components.menu.styles
  (:require [reframe.styles.break :refer [break]]
            [garden.units :as units]
            [garden.stylesheet :refer [at-media]]
            [reframe.styles.misc :as misc]
            [reframe.styles.color :refer [color]]))

(def toggle-size (units/em 2.5))

(def styles
  [:&-menu {:text-align "center"}
   [:&-toggle {:position "absolute"
               :bottom "3px"
               :right "3px"
               :height toggle-size
               :width toggle-size
               :border-radius (units/em-div toggle-size 2)
               :box-shadow misc/default-shadow
               :z-index 1000}
    (at-media
     {:min-width (:tablet break)}
     [:& {:display "none"}]
    )]
   [:div {:display "none"
          :padding "0.5em"}
    [:&:hover {:background-color (:hover color)}]
    (at-media
     {:min-width (:tablet break)}
     [:& {:display "block" }]
     )]
   [:&.show {:position "relative"
             :border-top misc/default-border}
    [:.reframe-menu-toggle {:top 0
                            :margin-top (units/em- 0 (units/em-div toggle-size 2))}]
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
