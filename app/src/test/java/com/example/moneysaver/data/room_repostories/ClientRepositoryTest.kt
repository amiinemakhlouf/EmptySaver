package com.example.moneysaver.data.room_repostories

import com.example.moneysaver.dao.FakeClientDao
import com.example.moneysaver.data.db.ClientDao
import com.example.moneysaver.data.db.entities.ClientModelClass
import com.example.moneysaver.repostories.ClientRepository
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking

import org.junit.Before
import org.junit.Test

class ClientRepositoryTest {
    private  lateinit var  clienRepository: ClientRepository
    private  lateinit var clientDao: FakeClientDao
    @Before
    fun setUp() {
        clientDao= FakeClientDao()
    clienRepository= ClientRepository(clientDao)

    }
    @Test
    fun remove(){
        clientDao.list.add(
            ClientModelClass("","d",1.500,2.200) )
        runBlocking {
            clienRepository.delete(ClientModelClass("","d",1.500,2.200))
        }
        assertThat(clientDao.list).doesNotContain(
            ClientModelClass("","d",1.500,2.200))

    }
    @Test
    fun upsert(){
        runBlocking {         clienRepository.upsert(ClientModelClass("","d",1.500,2.200))
        }
        assertThat(clientDao.list).contains( ClientModelClass("","d",1.500,2.200))

    }
}

