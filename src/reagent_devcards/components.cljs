(ns reagent-devcards.components
  (:require [reagent.core :as ra]))

(defn working []
  [:div "This is working"])

(defn title-component []
  [:h1 "Testing Reagent title"])

(defn clicking-component []
  (let [counter (ra/atom 0)]
    (fn []
      [:div
       [:div
        [:span
         (str "You clicked " @counter " times.")]
        (when (> @counter 3) [:span " You clicker!"])]
       [:button
        {:on-click #(swap! counter inc)}
        "Click me!"]])))

(defn greeting-component []
  (let [name (ra/atom "World")]
    (fn []
      [:div
       [:div (str "Hello " @name "!")]
       [:label
        [:span "Your name: "]
        [:input
          {:type :text
           :placeholder @name
           :on-change #(reset! name (-> % .-target .-value))}]]])))

