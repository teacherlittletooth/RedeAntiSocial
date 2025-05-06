package br.qi.socialmediatarde.model

import br.qi.socialmediatarde.R

data class PostData(
    var imageProfile: Int = R.drawable.ic_launcher_foreground,
    var nameProfile: String = "Nome do perfil",
    var timeProfile: String = "Agora",
    var imagePost: Int = R.drawable.ic_launcher_background,
    var textPost: String = "Texto da postagem."
)
