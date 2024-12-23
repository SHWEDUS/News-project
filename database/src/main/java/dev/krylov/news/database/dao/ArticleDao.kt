package dev.krylov.news.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import dev.krylov.news.database.models.ArticleDB
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {

    @Query("SELECT * FROM articles")
    suspend fun getAll(): List<ArticleDB>

    @Query("SELECT * FROM articles")
    fun observeAll(): Flow<List<ArticleDB>>

    @Insert
    suspend fun insert(articles: List<ArticleDB>)

    @Delete
    suspend fun remove(articles: List<ArticleDB>)

    @Query("DELETE FROM articles")
    suspend fun clear()
}