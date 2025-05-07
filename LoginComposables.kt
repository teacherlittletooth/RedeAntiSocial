package br.qi.socialmedianoite

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.qi.socialmedianoite.ui.theme.SocialMediaNoiteTheme

@Composable
fun LogoLogin(
    @DrawableRes logo: Int,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = logo),
        contentDescription = "Logo da tela de login",
        modifier = modifier.height(150.dp)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(
    label: String,
    isPassword: Boolean,
    icon: ImageVector,
    modifier: Modifier = Modifier
) {
    var textValue by remember {
        mutableStateOf( TextFieldValue("") )
    }

    var hidePass by remember {
        mutableStateOf( true )
    }

    TextField(
        value = textValue,
        onValueChange = { textValue = it },
        label = {
            Text(text = label)
        },
        leadingIcon = {
            Icon(
                imageVector = icon,
                contentDescription = "Ícone da caixa de texto"
            )
        },
        trailingIcon = {
            if(isPassword) {
                IconButton(
                    onClick = { hidePass = !hidePass }
                ) {
                    Icon(
                        imageVector = if(hidePass) Icons.Outlined.Done else Icons.Outlined.Clear,
                        contentDescription = "Ícone para esconder a senha"
                    )
                }
            } else {
                hidePass = false
            }
        },
        visualTransformation = if(hidePass)
                               PasswordVisualTransformation('*')
                               else
                               VisualTransformation.None
    )//TextField
}


//////////////////////////////////////////////
@Preview
@Composable
fun MyTextFieldPreview() {
    SocialMediaNoiteTheme {
        MyTextField(
            label = "Senha",
            isPassword = true,
            icon = Icons.Outlined.Lock
        )
    }
}
