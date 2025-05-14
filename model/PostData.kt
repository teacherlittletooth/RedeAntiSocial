package br.com.redeantisocialtarde.model

import br.com.redeantisocialtarde.R

data class PostData(
    var imageUser: Int = R.drawable.ic_launcher_foreground,
    var nameUser: String = "Usuário",
    var timeUser: String = "Agora",
    var imagePost: Int = R.drawable.ic_launcher_background,
    var textPost: String = "Texto da postagem.",
)
