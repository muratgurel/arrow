package katz

class CofreeComonad<S> : Comonad<CofreeF<S>>, Typeclass {
    override fun <A, B> coflatMap(fa: HK<CofreeF<S>, A>, f: (HK<CofreeF<S>, A>) -> B): Cofree<S, B> =
            fa.ev().coflatMap(f)

    override fun <A> extract(fa: HK<CofreeF<S>, A>): A =
            fa.ev().extract()

    override fun <A, B> map(fa: HK<CofreeF<S>, A>, f: (A) -> B): Cofree<S, B> =
            fa.ev().map(f)

    override fun <A> duplicate(fa: HK<CofreeF<S>, A>): HK<CofreeF<S>, Cofree<S, A>> =
            fa.ev().duplicate()
}