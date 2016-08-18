(ns reframe.components.nav.sub
    (:require-macros [reagent.ratom :refer [reaction]])
    (:require [re-frame.core :as re-frame]))

(re-frame/register-sub
 :nav-show
 (fn [db _]
   (reaction (get-in @db [:nav :show]))))
