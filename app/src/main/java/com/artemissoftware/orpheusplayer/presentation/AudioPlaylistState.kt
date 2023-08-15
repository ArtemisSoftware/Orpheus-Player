package com.artemissoftware.orpheusplayer.presentation

import com.artemissoftware.orpheusplaylist.playaudio.data.models.Audio

data class AudioPlaylistState(
    val audioList: List<Audio> = emptyList(),
    val currentPlayBackPosition: Long = 0L,
)
