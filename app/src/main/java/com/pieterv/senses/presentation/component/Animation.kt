package com.pieterv.senses.presentation.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.pieterv.senses.R
import com.pieterv.senses.presentation.MainScreenState

@Composable
fun Animation(modifier: Modifier = Modifier, state: MainScreenState) {
    val compositionLight by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.anim_light))
    val compositionDark by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.anim_dark))
    LottieAnimation(
        modifier = modifier,
        composition = if (state.isCurrentlyDark) compositionDark else compositionLight,
        isPlaying = true,
        iterations = LottieConstants.IterateForever,
    )
}
