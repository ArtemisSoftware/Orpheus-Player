package com.artemissoftware.orpheusplayer.domain.usecases

import com.artemissoftware.orpheusplayer.data.repositories.AudioRepository
import javax.inject.Inject

class GetAudioDataListUseCase @Inject constructor(private val repository: AudioRepository) {

    suspend operator fun invoke() = repository.getAudioData()
}
