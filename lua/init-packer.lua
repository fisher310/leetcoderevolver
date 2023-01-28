-- This file can be loaded by calling `lua require('plugins')` from your init.vim

return require("packer").startup(function()
	-- Packer can manage itself
	use("wbthomason/packer.nvim")

	use({
		"folke/noice.nvim",
		requires = {
			"MunifTanjim/nui.nvim",
			"rcarriga/nvim-notify",
		},
	})

	-- colorscheme
	use("NTBBloodbath/doom-one.nvim")
	use("sainnhe/sonokai")
	use("artanikin/vim-synthwave84")
	use("ellisonleao/gruvbox.nvim")
	use("Mofiqul/vscode.nvim")
	use("Abstract-IDE/Abstract-cs")
	use("sainnhe/everforest")

	use("karb94/neoscroll.nvim")

	-- lsp
	use({
		"williamboman/mason.nvim",
		"williamboman/mason-lspconfig.nvim",
		"neovim/nvim-lspconfig",
	})

	use("hrsh7th/nvim-cmp") -- Autocompletion plugin
	use("hrsh7th/cmp-nvim-lsp") -- LSP source for nvim-cmp
	use("hrsh7th/cmp-buffer")
	use("hrsh7th/cmp-path")
	use("hrsh7th/cmp-cmdline")
	use("saadparwaiz1/cmp_luasnip") -- Snippets source for nvim-cmp
	use("onsails/lspkind-nvim")
	use("L3MON4D3/LuaSnip") -- Snippets plugin

	-- For vsnip users.
	use("hrsh7th/cmp-vsnip")
	use("hrsh7th/vim-vsnip")

	use("jose-elias-alvarez/typescript.nvim")
	use("jose-elias-alvarez/null-ls.nvim") -- for formatters and linters

	-- comment plugin
	use({
		"numToStr/Comment.nvim",
		config = function()
			require("Comment").setup()
		end,
	})

	-- explorer
	use({
		"nvim-tree/nvim-tree.lua",
		requires = {
			"nvim-tree/nvim-web-devicons", -- optional, for file icons
		},
		tag = "nightly", -- optional, updated every week. (see issue #1193)
	})

	use({
		"akinsho/bufferline.nvim",
		tag = "v2.*",
		requires = "nvim-tree/nvim-web-devicons",
		config = function()
			require("bufferline").setup({})
		end,
	})

	-- status line
	use({
		"windwp/windline.nvim",
		config = function()
			require("wlsample.airline")
		end,
	})

	-- Lua
	use({
		"folke/which-key.nvim",
		config = function()
			require("which-key").setup({})
		end,
	})

	use({ "nvim-telescope/telescope-fzf-native.nvim", run = "make" })
	use({ "nvim-telescope/telescope-dap.nvim" })

	use({
		"nvim-telescope/telescope.nvim",
		requires = {
			{ "nvim-lua/plenary.nvim" },
		},
	})

	use("MattesGroeger/vim-bookmarks")
	use("tom-anders/telescope-vim-bookmarks.nvim")
	use({
		"nvim-treesitter/nvim-treesitter",
		run = ":TSUpdate",
	})

	use({ "glepnir/lspsaga.nvim", branch = "main", requires = { { "nvim-tree/nvim-web-devicons" } } }) -- for specific version

	use({ "mhartington/formatter.nvim" })

	use("windwp/nvim-autopairs") -- Autopairs, integrates with both cmp and treesitter

	use("lewis6991/gitsigns.nvim")
	use({
		"tanvirtin/vgit.nvim",
		requires = {
			"nvim-lua/plenary.nvim",
		},
	})

	use("kdheepak/lazygit.nvim")

	use("akinsho/toggleterm.nvim")
	use("ahmedkhalf/project.nvim")
	use("lewis6991/impatient.nvim")
	use("lukas-reineke/indent-blankline.nvim")
	use("goolord/alpha-nvim")

	-- debug
	use("mfussenegger/nvim-dap")
	use({ "rcarriga/nvim-dap-ui", requires = { "mfussenegger/nvim-dap" } })

	use({ "weilbith/nvim-code-action-menu", cmd = "CodeActionMenu" })

	use({
		"kosayoda/nvim-lightbulb",
		requires = "antoinemadec/FixCursorHold.nvim",
	})

	use({
		"simrat39/rust-tools.nvim",
	})

	use("chentoast/marks.nvim")

	use("easymotion/vim-easymotion")

	-- golang
	-- use("leoluz/nvim-dap-go")

	-- rust
	use("rust-lang/rust.vim")

	-- database
	use("tpope/vim-dadbod")
	use({ "kristijanhusak/vim-dadbod-ui", after = "vim-dadbod" })
	use({ "kristijanhusak/vim-dadbod-completion" })

	use("j-hui/fidget.nvim")
	use("xiyaowong/nvim-transparent")
	use("axelvc/template-string.nvim")
	use("folke/todo-comments.nvim")
	use("mg979/vim-visual-multi")
	use("gcmt/wildfire.vim")
	use("tpope/vim-surround")
	use("tpope/vim-obsession")
	use("dhruvasagar/vim-prosession")

	-- require("packer").sync()
end)
