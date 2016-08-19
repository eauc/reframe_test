(ns reframe.components.tasks.styles
  (:require [reframe.styles.misc :as misc]
            [reframe.styles.break :refer [break]]))

(def styles
  [:&-tasks {:max-width (:pc break)}
   [:&-task {:border "1px solid #CCC"
             :margin "0.5em 0"}]
   [:&-delete {:float "right"
               :margin "3px"}]
   [:&-title {:margin "0.5em"}]
   [:&-body {:padding "0.2em 0.5em"}]
   [:&-updated {:font-size "0.8em"
                :font-style "italic"
                :color "rgba(0,0,0,0.5)"
                :padding "0 0.5em"}]])
