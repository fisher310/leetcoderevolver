
require('options')
require('keymaps')
require('init-packer')
require('init-cmp')
require('init-lsp')
require('init-lspsaga')
require('init-nvim-tree')
require('init-telescope')
require('init-neoscroll')
require('init-vgit')
require('init-formatter')
require('init-autopair')
require('init-gitsigns')
require('init-toggleterm')
require('init-project')
require('init-impatient')
require('init-indentline')
require('init-alpha')
require('lsp')
require('init-dap')
require('init-dapui')
require('nvim-lightbulb').setup({autocmd = {enabled = true}})
require('init-marks')

vim.cmd([[
set encoding=UTF-8
set cc=80
colorscheme vscode


]])

-- augroup jdtls_lsp
--     autocmd!
--     autocmd FileType java lua require'jdtls_setup'.setup()
-- augroup end

