local rt = require("rust-tools")

rt.setup({
    server = {
        on_attach = function(_, bufnr) 

            vim.keymap.set("n", "<C-space>", rt.hover_actions.hover_actions, {buffer = bufnr})
            vim.keymap.set("n", "<Leader>ca", rt.code_action_group.code_action_group, {buffer = bufnr})


        end,
    }
})

-- Update this path
local extension_path = vim.env.HOME .. '/.vscode/extensions/vadimcn.vscode-lldb-1.8.1/'
local codelldb_path = extension_path .. 'adapter/codelldb'
local liblldb_path = extension_path .. 'lldb/lib/liblldb.so'

local opts = {
    -- ... other configs
    dap = {
        adapter = require('rust-tools.dap').get_codelldb_adapter(
            codelldb_path, liblldb_path)
    }
}

-- Normal setup
require('rust-tools').setup(opts)
