package br.com.cardoso.micronaut

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("br.com.cardoso.micronaut")
		.start()
}

