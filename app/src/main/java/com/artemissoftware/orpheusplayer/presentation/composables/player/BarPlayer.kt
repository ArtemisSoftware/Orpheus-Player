package com.artemissoftware.orpheusplayer.presentation.composables.player

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.orpheusplayer.presentation.composables.DummyAudio
import com.artemissoftware.orpheusplayer.ui.theme.OrpheusPlayerTheme
import com.artemissoftware.orpheusplaylist.playaudio.data.models.Audio

@Composable
fun BarPlayer(
    progress: Float,
    onProgressChange: (Float) -> Unit,
    audio: Audio,
    isAudioPlaying: Boolean,
    onStart: () -> Unit,
    onNext: () -> Unit,
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            ArtistInfo(
                audio = audio,
                modifier = Modifier.weight(1f),
            )
            MediaPlayerController(
                isAudioPlaying = isAudioPlaying,
                onStart = { onStart.invoke() },
                onNext = { onNext.invoke() },
            )
        }
        Slider(
            value = progress,
            onValueChange = { onProgressChange.invoke(it) },
            valueRange = 0f..100f,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun BarPlayerPreview() {
    OrpheusPlayerTheme {


    BarPlayer(
        progress = 50f,
        onProgressChange = {},
        audio = DummyAudio.audioList[0],
        isAudioPlaying = true,
        onStart = { },
        onNext = {},
    )
    }
}
