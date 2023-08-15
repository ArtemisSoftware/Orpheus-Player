package com.artemissoftware.orpheusplayer.presentation.composables.player

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MediaPlayerController(
    isAudioPlaying: Boolean,
    onStart: () -> Unit,
    onNext: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .height(56.dp)
            .padding(4.dp),
    ) {
        PlayerIcon(
            icon = if (isAudioPlaying) {
                Icons.Default.Pause
            } else {
                Icons.Default.PlayArrow
            },
            backgroundColor = MaterialTheme.colorScheme.primary,
            onClick = {
                onStart.invoke()
            },
        )

        Spacer(modifier = Modifier.size(8.dp))

        Icon(
            imageVector = Icons.Default.SkipNext,
            contentDescription = null,
            modifier = Modifier.clickable {
                onNext.invoke()
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MediaPlayerControllerPreview() {
    MediaPlayerController(
        isAudioPlaying = true,
        onStart = {},
        onNext = {},
    )
}
