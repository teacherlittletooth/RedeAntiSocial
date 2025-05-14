package br.com.redeantisocialtarde.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.redeantisocialtarde.LogoLogin
import br.com.redeantisocialtarde.MyButton
import br.com.redeantisocialtarde.MySwitchState
import br.com.redeantisocialtarde.MyTextField
import br.com.redeantisocialtarde.R
import br.com.redeantisocialtarde.ui.theme.RedeAntiSocialTardeTheme

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier
) {
    Scaffold{
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .padding(it)
                .fillMaxSize()
        ) {
            LogoLogin(logo = R.drawable.ic_launcher_foreground)

            MyTextField(
                label = "Usuário",
                isPassword = false,
                icon = Icons.Outlined.AccountCircle
            )

            MyTextField(
                label = "Senha",
                isPassword = true,
                icon = Icons.Outlined.Lock
            )

            MySwitchState()

            MyButton(
                label = "Entrar",
                size = 250.dp
            )

            MyButton(
                label = "Registrar",
                size = 250.dp
            )
        }
    }
}

//////////////////////////////////////////////////////////
@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    RedeAntiSocialTardeTheme {
        LoginScreen()
    }
}
