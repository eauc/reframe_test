(ns reframe.components.auth.view
  (:require [re-frame.core :as re-frame]
            [reframe.db :as db]
            [reframe.components.auth.sub]
            [reframe.components.auth.handler]))

(defn on-login [result]
  (let [token (:idToken (js->clj result :keywordize-keys true))]
    (re-frame/dispatch [:auth-login token])))

(defn login []
  (let [lock (new js/Auth0Lock
                  (get-in db/default-db [:auth :client-id])
                  (get-in db/default-db [:auth :domain])
                  (clj->js {:ui {:autoClose true}
                            :auth {:loginAfterSignup false
                                   :redirect false
                                   :params {:scope "openid email permissions"}}}))]
    (. lock (on "authenticated" on-login))
    (. lock (show))))

(defn login-button []
  [:button {:on-click login} "Login"])

(defn logout-button []
  [:button {:on-click #(re-frame/dispatch [:auth-logout])} "Logout"])

(defn require-login []
  (let [login-active (re-frame/subscribe [:auth-login-active])]
    (fn [& children]
      (if (not @login-active)
        [login-button]
        (into [:div [logout-button]] children)))))
