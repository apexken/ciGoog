(ns hello-goog.sigh
  (:require [clojure.string :as str]
            ))

(prn (str ::h5.Bc))
[(str/replace (str ::h5.div) #"^:hello-goog.sigh/h5." "")]