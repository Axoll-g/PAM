package com.example.tugaspam_1

data class RegisteredUser(
    val firstName: String,
    val lastName: String,
    val username: String,
    val email: String,
    val password: String,
    val phoneNumber: String,
    val address: String,
    val birthDate: String
)

/**
 * Penyimpanan data user sederhana di memori (in-memory), cukup untuk kebutuhan
 * tugas ini karena belum ada backend/database. Kalau nanti butuh data yang
 * bertahan setelah aplikasi ditutup, tinggal ganti isinya pakai SharedPreferences
 * atau Room, tanpa perlu ubah cara pemanggilannya di Activity lain.
 */
object UserRepository {
    var registeredUser: RegisteredUser? = null
        private set

    fun register(user: RegisteredUser) {
        registeredUser = user
    }

    fun validateLogin(username: String, password: String): Boolean {
        val user = registeredUser ?: return false
        return user.username == username && user.password == password
    }
}
