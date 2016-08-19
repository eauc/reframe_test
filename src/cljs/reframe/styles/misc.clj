(ns reframe.styles.misc
  (:require [reframe.styles.color :refer [color]]
            [garden.selectors :as selectors]))

(def default-border "1px solid #666")
(def default-border-radius "3px")
(def default-shadow "0px 1px 3px 0px #999")
(selectors/defselector input)
(def checkbox (input (selectors/attr= "type" "checkbox")))

(def styles
  [[:body :button {:color (:text color) }]
   [:label {:display "block"
            :margin "0.2em"
            :font-weight "bold"}
    [:&.reframe-form-checkbox {:margin-bottom "0.5em"}]]
   [:input {:display "block"
            :box-sizing "border-box"
            :width "100%"
            :padding "0.5em"
            :margin-bottom "0.5em"}]
   [checkbox {:display "inline"
              :width "auto"
              :margin "0.5em"}]
   [:button {:background-color "white"
             :padding "0.5em"
             :border default-border
             :border-radius default-border-radius}
    [:&:hover {:background-color (:hover color)}]
    [:&:focus {:outline "none"}]]])
