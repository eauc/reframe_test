(ns reframe.components.page.sub
    (:require-macros [reagent.ratom :refer [reaction]])
    (:require [re-frame.core :as re-frame]))

(re-frame/register-sub
 :pages-active
 (fn [db _]
   (reaction (get-in @db [:pages :active]))))
