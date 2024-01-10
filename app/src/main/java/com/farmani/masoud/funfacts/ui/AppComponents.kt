package com.farmani.masoud.funfacts.ui

import androidx.annotation.ArrayRes
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.farmani.masoud.funfacts.R
import kotlin.random.Random

@Composable
fun TopBar(text: String = "---") {
    Row(
        modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text, color = Color.Black, fontWeight = FontWeight.Medium, fontSize = 24.sp
        )

        Spacer(modifier = Modifier.weight(1f))

        Image(
            painter = painterResource(id = R.drawable.jetpack_compose_logo),
            contentDescription = "null",
            modifier = Modifier.size(80.dp)
        )

    }
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TopBar()
}

@Composable
fun TextComponent(
    textValue: String,
    textSize: TextUnit,
    colorValue: Color = Color.Black
) {

    Text(
        text = textValue, fontSize = textSize, color = colorValue, fontWeight = FontWeight.Light
    )
}

@Preview(showBackground = true)
@Composable
fun TextComponentPreview() {
    TextComponent(textValue = "Native Mobile Bits", textSize = 24.sp)
}

@Composable
fun TextFieldComponent(
    currentValue: String,
    onTextChanged: (String) -> Unit
) {
    val localFocusManager = LocalFocusManager.current
    OutlinedTextField(
        value = currentValue,
        onValueChange = {
            onTextChanged(it)
        },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Enter your name", fontSize = 18.sp) },
        singleLine = true,
        //textStyle will be applied to the text user will enter
        textStyle = TextStyle.Default.copy(fontSize = 24.sp),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            capitalization = KeyboardCapitalization.Words
        ),
        keyboardActions = KeyboardActions(onDone = { localFocusManager.clearFocus(true) })
    )
}

@Preview(showBackground = true)
@Composable
fun TextFieldComponentPreview() {
    TextFieldComponent("", onTextChanged = {})
}

@Composable
fun AnimalCard(
    @DrawableRes imageId: Int,
    onAnimalSelected: (animalName: String) -> Unit,
    isSelected: Boolean
) {
    val localFocusManager = LocalFocusManager.current
    Box(
        modifier = Modifier
            .padding(18.dp)
            .border(
                width = 1.dp,
                color = if (isSelected) Color.Green else Color.Transparent,
                shape = CardDefaults.shape
            )

    ) {
        Card(
            modifier = Modifier
                .size(120.dp),
            elevation = CardDefaults.cardElevation(4.dp),

            ) {
            Image(
                modifier = Modifier.clickable {
                    val animalName =
                        if (imageId == R.drawable.dog) "Dog" else "Cat"
                    onAnimalSelected(animalName)
                    localFocusManager.clearFocus()
                },
                painter = painterResource(id = imageId),
                contentDescription = ""
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AnimalCardPreview() {
    AnimalCard(R.drawable.dog, {}, true)
}

@Composable
fun ButtonComponent(
    onClickEvent: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClickEvent,
        modifier = modifier.fillMaxWidth(),
    ) {
        Text(
            text = "Go to details",
            style = TextStyle.Default.copy(fontWeight = FontWeight.Medium),
            fontSize = 18.sp
        )
    }
}

@Preview
@Composable
fun ButtonComponentPreview() {
    ButtonComponent({})
}

@Composable
fun TextWithShadow(
    textValue: String,
    textSize: TextUnit
) {
    val shadowOffset = Offset(x = 1f, y = 2f)
    Text(
        text = textValue,
        fontSize = textSize,
        fontWeight = FontWeight.Light,
        style = TextStyle(
            shadow = Shadow(
                color = generateRandomRGB(),
                offset = shadowOffset,
                blurRadius = 2f
            )
        )
    )
}

fun generateRandomRGB(): Color {
    return Color(
        red = Random.nextFloat(),
        green = Random.nextFloat(),
        blue = Random.nextFloat(),
        alpha = 1f
    )
}

@Preview(showBackground = true)
@Composable
fun TextWithShadowPreview() {
    TextWithShadow("You are a dog Lover", 24.sp)
}

@Composable
fun FactCard(selectedAnimal: String) {
    @ArrayRes val factResId = if(selectedAnimal == "Cat") R.array.cat_fun_facts else R.array.dog_fun_facts
    val factList = stringArrayResource(id = factResId)
    var factText by remember {
        mutableStateOf(factList.random())
    }
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable { factText = factList.random() },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.icon_quotation),
                contentDescription = "quotaion mark",
                modifier = Modifier.rotate(180f)
            )

            Spacer(modifier = Modifier.size(24.dp))

            TextWithShadow(factText, 24.sp)

            Spacer(modifier = Modifier.size(24.dp))

            Icon(
                painter = painterResource(id = R.drawable.icon_quotation),
                contentDescription = "quotation mark"
            )
        }
    }
}

@Preview
@Composable
fun FactCardPreview() {
    FactCard("This is and interesting fact!")
}