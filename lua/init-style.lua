require 'fidget'.setup({
    window = {
        blend = 0
    }
})

require 'todo-comments'.setup()

require('transparent').setup({
    enable = true,
    extra_groups = {
        "Comment"
    },
    exclude = {}
})

require 'noice'.setup({
    messages = {
        enable = false
    }
})

require 'notify'.setup({
    background_colour = "#000000",
    render = "default"
})
