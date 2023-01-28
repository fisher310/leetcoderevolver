local on_attach = function(_, bufnr)

    -- Enable completion triggered by <c-x><c-o>
    vim.api.nvim_buf_set_option(bufnr, 'omnifunc', 'v:lua.vim.lsp.omnifunc')

    -- Mappings.
    -- See `:help vim.lsp.*` for documentation on any of the below functions
    local bufopts = { noremap = true, silent = true, buffer = bufnr }
    vim.keymap.set('n', 'gD', vim.lsp.buf.declaration, bufopts)
    vim.keymap.set('n', 'gd', vim.lsp.buf.definition, bufopts)
    -- vim.keymap.set('n', 'K', vim.lsp.buf.hover, bufopts)
    vim.keymap.set('n', 'gi', vim.lsp.buf.implementation, bufopts)
    vim.keymap.set('n', '<C-k>', vim.lsp.buf.signature_help, bufopts)
    vim.keymap.set('n', '<space>wa', vim.lsp.buf.add_workspace_folder, bufopts)
    vim.keymap.set('n', '<space>wr', vim.lsp.buf.remove_workspace_folder, bufopts)
    vim.keymap.set('n', '<space>wl', function()
        print(vim.inspect(vim.lsp.buf.list_workspace_folders()))
    end, bufopts)
    vim.keymap.set('n', '<space>D', vim.lsp.buf.type_definition, bufopts)
    -- vim.keymap.set('n', '<space>rn', vim.lsp.buf.rename, bufopts)
    -- vim.keymap.set('n', '<space>ca', vim.lsp.buf.code_action, bufopts)
    vim.keymap.set('n', 'gr', vim.lsp.buf.references, bufopts)
    vim.keymap.set('n', '<space>f', function() vim.lsp.buf.format { async = true } end, bufopts)

    -- format on save
    vim.api.nvim_create_autocmd('BufWritePre', {
        group = vim.api.nvim_create_augroup('LspFormatting', { clear = true }),
        buffer = bufnr,
        callback = function()
            vim.lsp.buf.format()
        end
    })
end


local capabilities = require('cmp_nvim_lsp').default_capabilities()

local lsp_config = {
    capabilities = capabilities,
    on_attach = function(_, bufnr)
        on_attach(_, bufnr)
    end
}

require('mason-lspconfig').setup_handlers({
    function(server_name)
        require('lspconfig')[server_name].setup(lsp_config)
    end,
    sumneko_lua = function()
        require('lspconfig').sumneko_lua.setup(vim.tbl_extend('force', lsp_config, {
            settings = {
                Lua = {
                    diagnostics = {
                        globals = { 'vim' }
                    }
                }
            }
        }))
    end,
    tsserver = function()
        require('typescript').setup({
            server = vim.tbl_extend('force', lsp_config, {
                on_attach = function(_, bufnr)
                    on_attach(_, bufnr)
                end,
                init_options = {
                    preferences = {
                        importModuleSpecifierPreference = 'project=relative',
                        jsxAttributeCompletionStylr = 'none'
                    }
                }
            })
        })
    end
})

-- vim.keymap.set('n', '<leader>o', '<cmd>TypescriptOrganizeImports<cr>')
-- vim.keymap.set('n', '<leader>a', '<cmd>TypescriptAddMissingImports<cr>')
-- vim.keymap.set('n', '<leader>r', '<cmd>TypescriptRemoveUnused<cr>')
