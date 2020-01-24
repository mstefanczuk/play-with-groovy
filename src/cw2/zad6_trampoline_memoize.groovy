package cw2

// Przedstawić ciekawe i praktycznie użyteczne zastosowania trampoline() i memoize().


// silnia bez trampoline - wystąpi StackOverflow
def factorial
factorial = { n, acc = 1G -> 1 >= n ? acc : factorial(n - 1, acc * n ) }

println factorial(1000)

// silnia z trampoline - brak StackOverflow
def factorialTrampoline
factorialTrampoline = { n, acc = 1G -> 1 >= n ? acc : factorialTrampoline.trampoline(n - 1, acc * n ) }.trampoline()

println factorialTrampoline(1000)


// slinia z memoize - wczesniej obliczone wyniki są cacheowane i przy kolejnych wywołaniach zwracane bez liczenia
def factorialMemoize = {
    println "First call for $it!"
    def result = 1
    for (def i = 1; i <= it; i++)
        result *= i

    return result
}.memoize()

def args = [1, 2, 3, 2, 4, 3]
args.each {
    def result = factorialMemoize(it)
    println "$it! = $result"
}
