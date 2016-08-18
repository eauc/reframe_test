(ns reframe.components.menu.styles
  (:require [reframe.styles.break :refer [break]]
            [garden.units :as units]
            [garden.stylesheet :refer [at-media]]))

(def toggle-size (units/em 2.5))

(def styles
  [:&-menu {:text-align "center"}
   [:&-toggle {:position "absolute"
               :bottom "3px"
               :right "3px"
               :height toggle-size
               :width toggle-size
               :background-color "white"
               :color "#333"
               :border "1px solid #666"
               :border-radius (units/em-div toggle-size 2)
               :box-shadow "0px 1px 3px 0px #999"
               :z-index 1000}
    [:&:hover {:background-color "#CCC"}]
    [:&:focus {:outline "none"}]
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
   [:&.show {:position "relative"
             :border-top "1px solid #999"}
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
