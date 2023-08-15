package com.artemissoftware.orpheusplayer.domain.usecases

import com.artemissoftware.orpheusplayer.data.repositories.AudioRepository
import com.artemissoftware.orpheusplaylist.playaudio.data.models.Audio
import javax.inject.Inject

class GetAudioDataListUseCase @Inject constructor(private val repository: AudioRepository) {

    suspend operator fun invoke(): List<Audio> {
        val result = repository.getAudioData()
        return result
    }
}
