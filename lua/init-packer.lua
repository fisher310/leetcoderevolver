-- This file can be loaded by calling `lua require('plugins')` from your init.vim

return require('packer').startup(function()
  -- Packer can manage itself
  use 'wbthomason/packer.nvim'

  -- colorscheme
  use 'NTBBloodbath/doom-one.nvim'
  use 'sainnhe/sonokai'

  use 'karb94/neoscroll.nvim'

  -- lsp
  use 
    {
        "williamboman/nvim-lsp-installer",
        config = function ()
            require("nvim-lsp-installer").setup {}
        end
    }
  use {
        "neovim/nvim-lspconfig",
        config = function()
            local lspconfig = require("lspconfig")
            lspconfig.sumneko_lua.setup {}
            --- ...
        end
    }
  use "jose-elias-alvarez/null-ls.nvim" -- for formatters and linters

  use 'hrsh7th/nvim-cmp' -- Autocompletion plugin
  use 'hrsh7th/cmp-nvim-lsp' -- LSP source for nvim-cmp
  use 'hrsh7th/cmp-buffer'
  use 'hrsh7th/cmp-path'
  use 'hrsh7th/cmp-cmdline'
  use 'saadparwaiz1/cmp_luasnip' -- Snippets source for nvim-cmp
  use 'L3MON4D3/LuaSnip' -- Snippets plugin

  -- For vsnip users.
  use 'hrsh7th/cmp-vsnip'
  use 'hrsh7th/vim-vsnip'


  -- comment plugin
  use {
    'numToStr/Comment.nvim',
    config = function()
        require('Comment').setup()
    end
  }

  -- use {
  --     'kyazdani42/nvim-web-devicons',
  --     config = function()
  --         require('nvim-web-devicons').setup()
  --     end
  -- }

  -- explorer
  use {
    'kyazdani42/nvim-tree.lua',
    requires = {
      'kyazdani42/nvim-web-devicons', -- optional, for file icons
    },
    tag = 'nightly' -- optional, updated every week. (see issue #1193)
  }

  -- using packer.nvim
  use {'akinsho/bufferline.nvim', tag = "v2.*", requires = 'kyazdani42/nvim-web-devicons',
    config = function()
        require('bufferline').setup{}
    end
  }

  -- status line
  use {'windwp/windline.nvim',
    config = function()
        require('wlsample.bubble')
    end
  }

  -- Lua
  use {
    "folke/which-key.nvim",
    config = function()
      require("which-key").setup {
        -- your configuration comes here
        -- or leave it empty to use the default settings
        -- refer to the configuration section below
      }
    end
  }

  use {
    'nvim-telescope/telescope.nvim',
    requires = { {'nvim-lua/plenary.nvim'} }
  }

  use {
    'nvim-treesitter/nvim-treesitter', run = ':TSUpdate'
  }

  use { 'tami5/lspsaga.nvim', branch = 'nvim6.0' } -- for specific version

  use { 'mhartington/formatter.nvim' }

  -- Packer:
  use 'Mofiqul/vscode.nvim'
  use 'Abstract-IDE/Abstract-cs'



  use "windwp/nvim-autopairs" -- Autopairs, integrates with both cmp and treesitter

  use "lewis6991/gitsigns.nvim"
  --
  use {
    'tanvirtin/vgit.nvim',
    requires = {
    'nvim-lua/plenary.nvim'
    }
  }


  use "akinsho/toggleterm.nvim"

  use "ahmedkhalf/project.nvim"

  use 'lewis6991/impatient.nvim'

  use "lukas-reineke/indent-blankline.nvim"

  use 'goolord/alpha-nvim'

  -- debug
  use 'mfussenegger/nvim-dap'
  use { "rcarriga/nvim-dap-ui", requires = {"mfussenegger/nvim-dap"} }

  use { 'weilbith/nvim-code-action-menu', cmd = 'CodeActionMenu', }

  use {
    'kosayoda/nvim-lightbulb',
    requires = 'antoinemadec/FixCursorHold.nvim',
  }

  use {
    'simrat39/rust-tools.nvim'
  }

  use 'chentoast/marks.nvim'
  -- require("packer").sync()
end)
