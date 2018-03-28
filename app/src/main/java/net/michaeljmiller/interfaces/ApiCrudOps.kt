package net.michaeljmiller.interfaces

interface ApiCrudOps<T> {
    fun list(): Array<T>
    fun load(id: Int): T
    fun create(obj: T): Int
    fun update(obj: T): T
    fun delete(id: Int): Boolean
}