local actions = require("telescope.actions")
require("telescope").setup({
	defaults = {
		-- Default configuration for telescope goes here:
		-- config_key = value,
		layout_strategy = "horizontal",
		layout_config = {
			horizontal = {
				prompt_position = "bottom",
				preview_width = 0.55,
				results_width = 0.8,
			},
			vertical = { mirror = false },
			width = 0.87,
			height = 0.80,
			preview_cutoff = 120,
		},
		sorting_strategy = "ascending",
		prompt_prefix = "> ",
		selection_caret = " ",
		winblend = 0,
		mappings = {
			i = {
				-- map actions.which_key to <C-h> (default: <C-/>)
				-- actions.which_key shows the mappings for your picker,
				-- e.g. git_{create, delete, ...}_branch for the git_branches picker
				["<C-h>"] = "which_key",
				["<C-c>"] = actions.close,
			},
		},
	},
	pickers = {
		-- Default configuration for builtin pickers goes here:
		-- picker_name = {
		--   picker_config_key = value,
		--   ...
		-- }
		-- Now the picker_config_key will be applied every time you call this
		-- builtin picker
		find_files = {
			-- theme = 'dropdown'
		},
	},
	extensions = {
		-- Your extension configuration goes here:
		-- extension_name = {
		--   extension_config_key = value,
		-- }
		-- please take a look at the readme of the extension you want to configure
		fzf = {
			fuzzy = true, -- false will only do exact matching
			override_generic_sorter = true, -- override the generic sorter
			override_file_sorter = true, -- override the file sorter
			case_mode = "smart_case", -- or "ignore_case" or "respect_case" the default case_mode is "smart_case"
		},
        dap = {
        }
	},
})
require("telescope").load_extension("fzf")
require("telescope").load_extension("dap")
