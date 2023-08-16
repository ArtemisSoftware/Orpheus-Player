package com.artemissoftware.orpheusplayer.presentation

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.artemissoftware.orpheusplayer.presentation.composables.AudioItem
import com.artemissoftware.orpheusplayer.presentation.composables.DummyAudio
import com.artemissoftware.orpheusplayer.presentation.composables.player.BarPlayer
import com.artemissoftware.orpheusplaylist.playaudio.data.models.Audio

@Composable
fun AudioPlaylistScreen(viewModel: AudioPlaylistViewModel = hiltViewModel()) {
    val state = viewModel.state.collectAsState().value

    AudioPlaylistScreenContent(
        state = state,
        events = viewModel::onTriggerEvent,
        progress = viewModel.currentAudioProgress.value,
        currentPlayingAudio = viewModel.currentPlayingAudio.value,
        isAudioPlaying = viewModel.isAudioPlaying,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AudioPlaylistScreenContent(
    state: AudioPlaylistState,
    events: (AudioPlaylistEvents) -> Unit,
    progress: Float,
    isAudioPlaying: Boolean,
    currentPlayingAudio: Audio?,
) {
    val scaffoldState = rememberBottomSheetScaffoldState()

    val animatedHeight by animateDpAsState(
        targetValue = if (currentPlayingAudio == null) {
            0.dp
        } else {
            56.dp
        },
    )

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetContent = {
            currentPlayingAudio?.let { currentPlayingAudio ->
                BarPlayer(
                    progress = progress,
                    onProgressChange = {
                        events.invoke(AudioPlaylistEvents.SeekTo(it))
                    },
                    audio = currentPlayingAudio,
                    isAudioPlaying = isAudioPlaying,
                    onStart = {
                        events.invoke(AudioPlaylistEvents.PlayAudio(audio = currentPlayingAudio))
                    },
                    onNext = {
                        events.invoke(AudioPlaylistEvents.SkipToNext)
                    },
                )
            }
        },
        sheetPeekHeight = animatedHeight,
    ) {
        LazyColumn(
            contentPadding = PaddingValues(bottom = 56.dp),
        ) {
            items(state.audioList) { audio: Audio ->
                AudioItem(
                    audio = audio,
                    onItemClick = {
                        events.invoke(AudioPlaylistEvents.PlayAudio(audio = audio))
                    },
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AudioPlaylistScreenContentPreview() {
    AudioPlaylistScreenContent(
        events = {},
        state = AudioPlaylistState(
            audioList = DummyAudio.audioList,
        ),
        progress = 0F,
        isAudioPlaying = false,
        currentPlayingAudio = null,
    )
}
