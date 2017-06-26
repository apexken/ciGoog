(ns cigoog.types
  (:require [tiltontec.util.core :as util]))

(def h5-type-tree
  [::h5.Object
   ::h5.div
   ::h5.title ::h5.h2 ::h5.h3 ::h5.h4 ::h5.h5
   ::h5.p ::h5.label
   ::h5.button ::h5.input
   ::h5.ul ::h5.li
   ])


(defn derive-tree [super tree]
  (let [[class & subs] (util/ensure-vec tree)]
    (when super
      (derive class super))
    (doseq [sub subs]
      (derive-tree class sub))))

(derive-tree nil h5-type-tree)

