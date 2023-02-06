local opts = { noremap = true, silent = true }
-- Shorten function name
-- local keymap = vim.api.nvim_set_keymap
local keymap = vim.keymap.set

--Remap space as leader key
keymap("", "<Space>", "<Nop>", opts)
vim.g.mapleader = " "
vim.g.maplocalleader = " "

keymap('n', '<leader>e', '<cmd>NvimTreeToggle<CR>')
keymap('n', '<leader>fc', '<cmd>NvimTreeFindFile<CR>')
keymap('n', '<leader>fr', '<cmd>NvimTreeRefresh<CR>')
keymap('n', '<leader>ff', '<cmd>Telescope find_files<CR>')
keymap('n', '<leader>fg', '<cmd>Telescope live_grep<CR>')
keymap('n', '<leader>bb', '<cmd>Telescope buffers<CR>')
keymap('n', '<leader>fh', ':Telescope help_tags<CR>')
keymap('n', '<leader>=f', ':Format<CR>')
keymap('n', '<leader>=F', ':FormatWrite<CR>')
-- vim.keymap.set('i', 'jk', '<ESC>')
keymap('n', 'L', '$', opts)
-- vim.keymap.set('n', 'gl', '$', opts)
keymap('v', 'L', '$', opts)
-- vim.keymap.set('n', 'H', '^', opts)
-- vim.keymap.set('n', 'gh', '^', opts)
keymap('v', 'H', '^', opts)
keymap('n', '<C-a>', 'gg<S-v>G', opts)
vim.keymap.set('n', '<leader>j', '<Plug>(easymotion-bd-f)')
-- keymap('n', '<leader>j', '<Plug>(easymotion-s1)')
keymap('n', '<leader>gg', ':LazyGit<CR>', opts)
keymap('i', 'jj', '<ESC>', opts)
keymap('i', 'jk', '<ESC>la', opts)
keymap("n", ";;", "A;<ESC>o")
keymap("i", "j;", "<ESC>A;<ESC>o")
keymap('n', '<leader>tr', ':RustRun<CR>', opts)
keymap('n', '<leader>tt', ':RustTest<CR>', opts)
keymap('n', '<leader>ta', ':RustTest!<CR>', opts)
keymap('n', '<leader>ss', ':w<CR>')



keymap('n', '<leader>gd', ':Gitsigns diffthis<CR>')

vim.cmd([[
  nnoremap <silent> <leader>dn :lua require('dap-python').test_method()<cr>
  nnoremap <silent> <leader>df :lua require('dap-python').test_class()<cr>
  vnoremap <silent> <leader>ds <esc>:lua require('dap-go').debug_selection()<cr>
  nnoremap <silent> <leader>dut :lua require('dapui').toggle()<cr>
  nnoremap <slient> <leader>dro :lua require('dap').repl.open()<cr>
  nnoremap <silent> <f3> :lua require('dap').toggle_breakpoint()<cr>
  nnoremap <silent> <f5> :lua require('dap').continue()<cr>
  nnoremap <silent> <f8> :lua require('dap').step_over()<cr>
  nnoremap <silent> <f7> :lua require('dap').step_into()<cr>
  " nnoremap <silent> <leader>ca :codeactionmenu<cr>
  nnoremap <silent> <leader>m :lua require('telescope.builtin').lsp_document_symbols()<cr>
  nnoremap <silent> gr :lua require('telescope.builtin').lsp_references()<cr>

]])

keymap('n', '<leader>dcc', '<cmd>Telescope dap commands<CR>')
keymap('n', '<leader>dcf', '<cmd>Telescope dap configurations<CR>')
keymap('n', '<leader>dl', '<cmd>Telescope dap list_breakpoints<CR>')
keymap('n', '<leader>dv', '<cmd>Telescope dap variables<CR>')
keymap('n', '<leader>df', '<cmd>Telescope dap frames<CR>')


--Lsp

-- Lspsaga
keymap("n", "gh", "<cmd>Lspsaga lsp_finder<CR>", { silent = true })
keymap({ "n", "v" }, "<leader>ca", "<cmd>Lspsaga code_action<CR>")
keymap("n", "gd", "<cmd>Lspsaga goto_definition<CR>")
keymap("n", "<leader>rn", "<cmd>Lspsaga rename<CR>", { silent = true })
keymap("n", "<leader>rp", "<cmd>Lspsaga rename ++project<CR>")
keymap("n", "<leader>cd", "<cmd>Lspsaga show_line_diagnostics<CR>", { silent = true })
keymap("n", "<leader>cd", "<cmd>Lspsaga show_cursor_diagnostics<CR>", { silent = true })
keymap("n", "[e", "<cmd>Lspsaga diagnostic_jump_prev<CR>", { silent = true })
keymap("n", "]e", "<cmd>Lspsaga diagnostic_jump_next<CR>", { silent = true })
keymap("n", "[E", function() require("lspsaga.diagnostic").goto_prev({ severity = vim.diagnostic.severity.ERROR }) end,
    { silent = true })
keymap("n", "]E", function() require("lspsaga.diagnostic").goto_next({ severity = vim.diagnostic.severity.ERROR }) end,
    { silent = true })
-- Outline
keymap("n", "<leader>o", "<cmd>Lspsaga outline<CR>", { silent = true })
-- Hover Doc
keymap("n", "K", "<cmd>Lspsaga hover_doc++<CR>", { silent = true })
-- Call hierarchy
keymap("n", "<Leader>ci", "<cmd>Lspsaga incoming_calls<CR>")
keymap("n", "<Leader>co", "<cmd>Lspsaga outgoing_calls<CR>")



