package br.com.redeantisocialtarde

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.redeantisocialtarde.ui.theme.RedeAntiSocialTardeTheme

@Composable
fun LogoLogin(
    @DrawableRes logo: Int,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = logo),
        contentDescription = "Logotipo do Login",
        modifier = modifier.size(200.dp)
    )
}

@Composable
fun MyTextField(
    label: String,
    isPassword: Boolean,
    icon: ImageVector,
    modifier: Modifier = Modifier
) {
    var textValue by remember {
        mutableStateOf(TextFieldValue(""))
    }

    var hidePass by remember {
        mutableStateOf(true)
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
                    onClick = { hidePass = !hidePass },
                ) {
                    Icon(
                        imageVector = if (hidePass) Icons.Rounded.Clear else Icons.Rounded.Done,
                        contentDescription = "Ícone de senha"
                    )
                }
            } else {
                hidePass = false
            }
        },
        visualTransformation = if(hidePass)
                                PasswordVisualTransformation('x')
                                else
                                VisualTransformation.None
    )
}

//////////////////////////////////////////////

@Preview
@Composable
fun MyTextFieldPreview() {
    RedeAntiSocialTardeTheme {
        MyTextField(
            isPassword = true,
            icon = Icons.Filled.AccountCircle,
            label = "Usuário"
        )
    }
}
