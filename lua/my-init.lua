if vim.g.vscode then
	-- VSCode extension
	-- Plug 'asvetliakov/vim-easymotion'
	local keymap = vim.api.nvim_set_keymap
	vim.g.mapleader = " "
	vim.g.maplocalleader = " "

else
	require("keymaps")
	require("options")
	require("init-packer")
	require("init-cmp")
	require("init-lsp")
	require("init-lspsaga")
	require("init-nvim-tree")
	require("init-telescope")
	require("init-neoscroll")
	require("init-vgit")
	require("init-formatter")
	require("init-autopair")
	require("init-gitsigns")
	require("init-toggleterm")
	require("init-project")
	require("init-impatient")
	require("init-indentline")
	require("init-alpha")
	-- require('lsp')
	require("init-dap")
	require("init-dapui")
	require("nvim-lightbulb").setup({ autocmd = { enabled = true } })
	require("init-marks")
    require("init-rust-tools")
    require("init-lazygit")
end
