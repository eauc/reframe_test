(ns reframe.components.menu.sub
    (:require-macros [reagent.ratom :refer [reaction]])
    (:require [re-frame.core :as re-frame]))

(re-frame/register-sub
 :menu-show
 (fn [db _]
   (reaction (get-in @db [:menu :show]))))
