require('vgit').setup()

vim.cmd([[
  set statusline+=%{get(b:,'vgit_status','')}
]])
