#!/usr/bin/env bash

clojure -M \
	--main cljs.main \
	--output-dir public/js \
	--compile-opts '{:asset-path "js"}' \
	--verbose \
	--watch src \
	--repl-opts '{:static-dir "public"}'\
	--compile jamesdavidson.replicant.svg.demo \
	--repl
