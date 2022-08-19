local opts = { noremap = true, silent = true }
-- Shorten function name
local keymap = vim.api.nvim_set_keymap

--Remap space as leader key
keymap("", "<Space>", "<Nop>", opts)
vim.g.mapleader = " "
vim.g.maplocalleader = " "

vim.keymap.set('n', '<leader>ft', ':NvimTreeToggle<CR>')
vim.keymap.set('n', '<leader>fc', ':NvimTreeFindFile<CR>')
vim.keymap.set('n', '<leader>fr', ':NvimTreeRefresh<CR>')
vim.keymap.set('n', '<leader>ff', ':Telescope find_files<CR>')
vim.keymap.set('n', '<leader>fg', ':Telescope live_grep<CR>')
vim.keymap.set('n', '<leader>fb', ':Telescope buffers<CR>')
vim.keymap.set('n', '<leader>fh', ':Telescope help_tags<CR>')
vim.keymap.set('n', '<leader>=f', ':Format<CR>')
vim.keymap.set('n', '<leader>=F', ':FormatWrite<CR>')
vim.keymap.set('i', 'jj', '<ESC>')


vim.keymap.set('n', '<leader>gd', ':Gitsigns diffthis<CR>')

vim.cmd([[
  nnoremap <silent> <leader>dn :lua require('dap-python').test_method()<CR>
  nnoremap <silent> <leader>df :lua require('dap-python').test_class()<CR>
  vnoremap <silent> <leader>ds <ESC>:lua require('dap-python').debug_selection()<CR>
  nnoremap <silent> <leader>dut :lua require('dapui').toggle()<CR>
  nnoremap <slient> <leader>dro :lua require('dap').repl.open()<CR>
  nnoremap <silent> <F3> :lua require('dap').toggle_breakpoint()<CR>
  nnoremap <silent> <F5> :lua require('dap').continue()<CR>
  nnoremap <silent> <F8> :lua require('dap').step_over()<CR>
  nnoremap <silent> <F7> :lua require('dap').step_into()<CR>
  nnoremap <silent> <leader>/ :CodeActionMenu<CR>

]])
