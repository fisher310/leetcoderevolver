-- examples for your init.lua

-- empty setup using defaults
require("nvim-tree").setup({
    auto_reload_on_write = true,
    view = {
        signcolumn = 'yes',
        mappings = {
            custom_only = false,
            list = {
                { key = '-', action = 'dir_up'},
-- the default mappings see :h nvim-tree-default-mappings
            }
        }
    }

})

-- OR setup with some options
-- require("nvim-tree").setup({
--   sort_by = "case_sensitive",
--   view = {
--     adaptive_size = true,
--     mappings = {
--       list = {
--         { key = "u", action = "dir_up" },
--       },
--     },
--   },
--   renderer = {
--     group_empty = true,
--   },
--   filters = {
--     dotfiles = true,
--   },
-- })
